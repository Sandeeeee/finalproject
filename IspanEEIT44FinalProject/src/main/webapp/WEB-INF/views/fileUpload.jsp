<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>File to base64</title>
    <style>
    </style>
    <script>
        window.onload = function () {
            var input = document.getElementById("fielinput");
            var txshow = document.getElementById("txshow");
            if (typeof (FileReader) === 'undefined') {
                result.innerHTML = "瀏覽器不支持 FileReader！";
                input.setAttribute('disabled', 'disabled');
            } else {
                input.addEventListener('change', readFile, false);
                txshow.onclick = function () { input.click(); }
            }
        }
        function readFile() {
            var file = this.files[0];
            //判断是否是圖片類型
            /*if (!/image\/\w+/.test(file.type)) {
                alert("只能選擇圖片");
                return false;
            }*/
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                txshow.src = this.result;
//                 document.getElementById("data").innerText = this.result.substring(this.result.indexOf(',') + 1);
            	console.log(txshow.src);
            }
        }
    </script>
</head>

<body>
    <input type="file" id="fielinput" />
    <img id="txshow" style="width:100px;height:100px;" />
<!--     <br />解析後的base64數據：<br /> -->
<!--     <p id="data"></p> -->
</body>
</html>