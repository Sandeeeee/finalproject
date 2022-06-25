
var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var senderId = null;
var receiverId = null;
var senderName = null;
var receiverName = null;
var channel = null;
var colors = [
	'#2196F3', '#32c787', '#00BCD4', '#ff5652',
	'#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
	username = document.getElementById("senderId").innerText;
	senderId = document.getElementById("senderId").innerText;
	receiverId = document.getElementById("receiverId").innerText;
	senderName = document.getElementById("senderName").innerText;
	receiverName = document.getElementById("receiverName").innerText;
	channel = document.getElementById("channel").innerText;
	if (username) {
		// usernamePage.classList.add('hidden');
		chatPage.classList.remove('hidden');

		var socket = new SockJS('/ws');
		stompClient = Stomp.over(socket);

		stompClient.connect({}, onConnected, onError);
	}
	//event.preventDefault();
}


function onConnected() {
	// Subscribe to the Public Topic
	var path = "";
	if (receiverId.localeCompare(senderId) == 1) {
		path = senderId + ":" + receiverId;
	} else {
		path = receiverId + ":" + senderId;
	}
	console.log("PATH:" + path);
	stompClient.subscribe('/topic/public/' + path, onMessageReceived);

	// Tell your username to the server
	// stompClient.send("/app/chat.addUser",
	//       {},
	//       JSON.stringify({sender: username, type: 'JOIN'})
	//   )

	connectingElement.classList.add('hidden');
	addHistory();
}


function onError(error) {
	connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	connectingElement.style.color = 'red';
}


function sendMessage(event) {
	var messageContent = messageInput.value.trim();

	if (messageContent && stompClient) {
		var chatMessage = {
			senderId: senderId,
			content: messageInput.value,
			receiverId: receiverId,
			senderName: senderName,
			receiverName: receiverName,
			channel: channel

		};

		stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
		messageInput.value = '';
	}
	event.preventDefault();
}


function onMessageReceived(payload) {
	var message = JSON.parse(payload.body);

	var messageElement = document.createElement('li');


	messageElement.classList.add('chat-message');

	var avatarElement = document.createElement('i');
	var avatarText = document.createTextNode(message.senderName[0]);
	avatarElement.appendChild(avatarText);
	avatarElement.style['background-color'] = getAvatarColor(message.senderName);

	messageElement.appendChild(avatarElement);

	var usernameElement = document.createElement('span');
	var usernameText = document.createTextNode(message.senderName);
	usernameElement.appendChild(usernameText);
	messageElement.appendChild(usernameElement);


	var textElement = document.createElement('p');
	var messageText = document.createTextNode(message.content);
	textElement.appendChild(messageText);

	messageElement.appendChild(textElement);

	messageArea.appendChild(messageElement);
	messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
	var hash = 0;
	for (var i = 0; i < messageSender.length; i++) {
		hash = 31 * hash + messageSender.charCodeAt(i);
	}

	var index = Math.abs(hash % colors.length);
	return colors[index];
}

function addHistory() {
	var mydata = null;
	$.get("/getChatData?sender=" + senderId + "&" + "receiver=" + receiverId+ "&channel=" + channel,
		function(data1, status) {

			console.log(JSON.stringify(data1));
			mydata = JSON.stringify(data1);

		}).done(function() {

			var jsonData = JSON.parse(mydata);
			for (var i = 0; i < jsonData.chatlist.length; i++) {
				var counter = jsonData.chatlist[i];
				console.log(counter);


				var messageElement = document.createElement('li');
				messageElement.classList.add('chat-message');
				var avatarElement = document.createElement('i');

				if (counter.senderId == senderId) {

					var avatarText = document.createTextNode(senderName[0]);
					avatarElement.appendChild(avatarText);
					avatarElement.style['background-color'] = getAvatarColor(senderName);
					messageElement.appendChild(avatarElement);
					var usernameElement = document.createElement('span');
					var usernameText = document.createTextNode(senderName);
					usernameElement.appendChild(usernameText);
					messageElement.appendChild(usernameElement);
				} else {
					var avatarText = document.createTextNode(receiverName[0]);
					avatarElement.appendChild(avatarText);
					avatarElement.style['background-color'] = getAvatarColor(receiverName);
					messageElement.appendChild(avatarElement);
					var usernameElement = document.createElement('span');
					var usernameText = document.createTextNode(receiverName);
					usernameElement.appendChild(usernameText);
					messageElement.appendChild(usernameElement);
				}



				var textElement = document.createElement('p');
				var messageText = document.createTextNode(counter.content);
				textElement.appendChild(messageText);

				messageElement.appendChild(textElement);

				messageArea.appendChild(messageElement);
				messageArea.scrollTop = messageArea.scrollHeight;
			}
		});






}

//usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
connect();
