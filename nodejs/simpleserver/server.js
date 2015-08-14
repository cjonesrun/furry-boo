// required modules
var http = require('http');
var url = require('url');
var path = require('path');
var fs = require('fs');

// mime types array
var mimeTypes = {
	"html" : "text/html",
	"jpeg" : "image/jpeg",
	"jpg" : "image/jpeg",
	"png" : "image/png",
	"js" : "text/javascript",
	"css" : "text/css"
};

// create server
http.createServer(function (req, res) {

	var uri = url.parse(req.url).pathname;
	var filename = path.join(process.cwd(), unescape(uri));

	console.log("Loading " + uri);
	var stats;

	try {
		stats = fs.lstatSync(filename);
	} catch (e) {
		res.writeHead(404, {'Content-Type': 'text/plain'});
		res.write('404 Not Found');
		res.end();
		return;
	}

	// check file or dir
	if (stats.isFile()) {
		var mimeType = mimeTypes[path.extname(filename).split(".").reverse()[0]];
		res.writeHead(200, {'Content-Type': mimeType});

		var fileStream = fs.createReadStream(filename);
		fileStream.pipe(res);
	} else if (stats.isDirectory()) {
		res.writeHead(302, {
			'Location' : 'index.html'			
		});
		res.end();
	} else {
		res.writeHead(500, {'Content-Type': 'text/plain'});
		res.write("500 Internal Error\n");
		res.end();
	};
}).listen(3000);
console.log('Server running at http://127.0.0.1:3000/');