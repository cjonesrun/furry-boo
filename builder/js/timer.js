
var start_time = new Date().getTime();

var global_timer; // main timer for auto block & thing building
var cookie_save_timer;



function startUIUpdater() {
    global_timer = setInterval(function(){ 
    	
        for (var i=0; i < items_arr.length; i++) {
            var item = items_arr[i];
            var prev = prev_map[item];
            var next = next_map[item];
            //addMessage( [items_arr[i], item_count_map[items_arr[i]] ] );
            var adjust = rate_map[item] * (UI_REFRESH_INTERVAL/1000);
            
            if (i>0) {
                if(item_count_map[ prev ] >= (BASE * adjust) ) {
                    item_count_map[ item ] += adjust;
                    //item_count_map[ prev ] -= BASE * adjust;
                }
                var newBuild = Math.floor( item_count_map[prev] / Math.pow(BASE,(i+1)) );
                item_count_map[item] += newBuild;
                getElement(prev+"_build_rate").value = numberFormat(newBuild) + '/s';
                getElement(prev).value = numberFormat(item_count_map[prev]);
            } else {
                item_count_map[ item ] += adjust;
            }
            getElement(item).value = numberFormat(item_count_map[item]);
        }
       
		getElement("running").value =  numberFormat(Math.floor( (new Date().getTime() - start_time) / 1000));
	}, UI_REFRESH_INTERVAL);
}

function setData() {
    for (var i=0; i < items_arr.length; i++) {

        var build_rate = Math.floor( item_count_map[item] / Math.pow(BASE,(i+1)) );

        getElement(items_arr[i]+"_build_rate").value = numberFormat(build_rate) + '/s';
        getElement(items_arr[i]+"_rate").value = numberFormat(rate_map[items_arr[i]]) + '/s';
        getElement(items_arr[i]).value = numberFormat(item_count_map[items_arr[i]]);

    }
}

function startCookieSaver() {
    cookie_save_timer = setInterval( function(){
        saveState();
    }, SAVE_INTERVAL);
}
 
function stopTimer() {

}

function startTimer() {

}

function update_timer_interval( )
{
	clearInterval(global_timer);

	UI_REFRESH_INTERVAL = numberFormat( parseInt( document.getElementById("timer").value ) );
	
	startUIUpdater();
}

// init from cookies if they are present, bfore starting the timer
initFromCookies();

startUIUpdater();
startCookieSaver();

addMessage(['starting prestige is', PRESTIGE_BASE+'^'+PRESTIGE_LEVEL,'=', numberFormat(prestigeMultiplier()) ] );
