//変数

//キャンバスの部分
var canvas = document.getElementById('canvas');
var c_context = canvas.getContext('2d');

var drawing = false;  //
var b_x = 0;　//描画した際の最後のx座標
var b_y = 0;　//描画した際の最後のy座標

//マウスが動いている時描画
canvas.addEventListener('mousemove',drawCanvas);

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
    if(!drawing){
        return
    };
//マウスが動いた位置に連続で描画していく
    var rect = e.target.getBoundingClientRect();
    var x = e.clientX - rect.left;
    var y = e.clientY - rect.top;

    c_context.lineCap = 'round';
    c_context.strokeStyle = 'black';
    c_context.lineWidth = '10px';
    c_context.beginPath();
    c_context.moveTo(b_x, b_y);
    c_context.lineTo(x, y);
    c_context.stroke();
    c_context.closePath();

    b_x = x;
    b_y = y;
}

//canvasをpng画像に変換する関数
function change_pngimage(){
    var png = canvas.toDataURL();
    // =png //png画像どどこかに保存
    document.getElementById("newImg").src = png;
}

function delete_canvas(){
    c_context.clearRect(0, 0, canvas.width, canvas.height);
}