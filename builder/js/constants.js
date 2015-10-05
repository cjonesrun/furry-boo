var BASE = 10;

var starting_interval = 1000; /// default to 1s

var items_arr = [ 'bit', 'part', 'block', 'thing', 'object', 'widget', 'contraption', 'gadget', 'doohickey', 'gismo', 'doodad', 'thingamabob', 'whatchamacalit', 'thingamajig', 'apparatus' ];
var levels_per_item = 5;

var rate_map = {};
var prev_map = {};
var next_map = {};
for (var i=0; i < items_arr.length; i++) {
	if (i > 0) 
		prev_map[items_arr[i]] = items_arr[i-1];
	if (i < items_arr.length-1)
		next_map[items_arr[i]] = items_arr[i+1];
	rate_map[items_arr[i]] = 0;
	
}

var block_rate = 0; // block rate
var things_rate = 0; // things rate
var things = 0  // the currency


var messagesWindow;
function addMessage(str_arr){
	if (!messagesWindow)
		messagesWindow = document.getElementById( 'messages' );
	var dump = str_arr.join(" ");
	messagesWindow.value = dump + "\n" + messagesWindow.value;
	// TODO: trim the log to, say, 1,000 characters
}
