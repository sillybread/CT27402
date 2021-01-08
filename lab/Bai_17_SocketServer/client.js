var socket = require('socket.io-client')('http://bai17.herokuapp.com/');
socket.on('connect', function(){
	console.log("Hit");
});