
var start_time = new Date().getTime();

// main timer for auto block & thing building
var global_timer;

function start(time) {
    global_timer = setInterval(function(){ 
    	for (var i=0; i < items_arr.length; i++) {
    		var item = items_arr[i];
    		var prev =prev_map[item];
    		var next = next_map[item];
    		//addMessage( [items_arr[i], item_count_map[items_arr[i]] ] );
    		var adjust = rate_map[item] * (time/1000);
    		
    		if (i>0) {
    		 	if(item_count_map[ prev ] >= (BASE * adjust) ) {
    				item_count_map[ item ] += adjust;
    				//item_count_map[ prev ] -= BASE * adjust;
    			}
    			var newBuild = Math.floor( item_count_map[prev] / Math.pow(BASE,(i+1)) );
    			item_count_map[item] += newBuild;
    			getElement(prev+"_build_rate").value = newBuild + '/s';
    			getElement(prev).value = item_count_map[prev];
    		} else {
				item_count_map[ item ] += adjust;
    		}
    		getElement(item).value = item_count_map[item];
    	}

		getElement("running").value =  Math.floor( (new Date().getTime() - start_time) / 1000);
	}, time);
}
 

function update_timer_interval( )
{
	clearInterval(global_timer);

	starting_interval = parseInt( document.getElementById("timer").value );
	
	start(starting_interval);
}

start(starting_interval);
