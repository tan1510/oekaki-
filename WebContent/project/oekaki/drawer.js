//変数
var eraserActivated = false;
//キャンバスの部分
var canvas = document.getElementById('canvas');
var c_context = canvas.getContext('2d');
c_context.fillStyle = 'rgb(255,255,255)';
    c_context.fillRect(0,0,512,512);
	   
var drawing = false;  //
var b_x = 0;　//描画した際の最後のx座標
var b_y = 0;　//描画した際の最後のy座標

function eraser(){
    if(eraserActivated){
        c_context.globalCompositeOperation = 'source-over';
        eraserActivated=false;
    }else{
        c_context.globalCompositeOperation  = 'destination-out';
        eraserActivated=true;
    }
    }

canvas.addEventListener('mousedown',function(e) {
    drawing = true;
    var rect = e.target.getBoundingClientRect();
    b_x = e.clientX - rect.left;
    b_y = e.clientY - rect.top;
});
//マウスを話した時drawingをfalseにする
canvas.addEventListener('mouseup',function(){
    drawing = false;
})


//mousemoveの時に実行する関数
function drawCanvas(e){
    var color = document.getElementById('color').value; //追加
    c_context.strokeStyle = color; //変更
    if(!drawing){
        return
    };
//マウスが動いた位置に連続で描画していく
    var rect = e.target.getBoundingClientRect();
    var x = e.clientX - rect.left;
    var y = e.clientY - rect.top;

    c_context.lineCap = 'round';
 //   c_context.strokeStyle = 'red';
    c_context.lineWidth = '10px';
    c_context.beginPath();
    c_context.moveTo(b_x, b_y);
    c_context.lineTo(x, y);
    c_context.stroke();
    c_context.closePath();
//最後のマウス位置の更新
    b_x = x;
    b_y = y;
}


//マウスが動いている時描画
canvas.addEventListener('mousemove',drawCanvas);
//canvasをpng画像に変換する関数
function change_pngimage(){
    var png = canvas.toDataURL();
    // =png //png画像どどこかに保存
    document.getElementById("newImg").src = png;
}

//canvasの状態をリセットする
function delete_canvas(){
    c_context.clearRect(0, 0, canvas.width, canvas.height);
}

var xmlHttpRequest;

function receive() {
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        console.log("receive")
        console.log(xmlHttpRequest.responseText)
		
	}
}

function sendWithPostMethod() {
    var base64 = canvas.toDataURL("png");
    console.log(base64);
    //decode
    //var encstr = encodeURIComponent(base64);
   // console.log("encoded")
   // console.log(encstr);
    var name = document.getElementById("savename").value;
  //  console.log(name);
	var url = "post";
	
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("POST", url, true);
	xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttpRequest.send("bin=" + base64 +"&name=" + name + "&method=post");
}

window.addEventListener("load",function() { 
    var postButtonElement = document.getElementById("send_data");
    postButtonElement.addEventListener("click", sendWithPostMethod, false);

},false);