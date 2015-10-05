
var start_time = new Date().getTime();

// main timer for auto block & thing building
var global_timer;

function start(time) {
    global_timer = setInterval(function(){ 
    	for (var i=0; i < items_arr.length; i++) {
    		var e = document.getElementById(items_arr[i]);
    		e.value = parseInt( e.value ) + rate_map[items_arr[i]] * (time/1000);
    	}

		document.getElementById("running").value =  Math.floor( (new Date().getTime() - start_time) / 1000);
	}, time);
}
 

function update_timer_interval( )
{
	clearInterval(global_timer);

	starting_interval = parseInt( document.getElementById("timer").value );
	
	start(starting_interval);
}

start(starting_interval);