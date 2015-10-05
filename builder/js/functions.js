function getElement(item)
{
	return document.getElementById(item);
}

function calc(level) {
	return Math.pow(BASE, level);
}

// build 10^level items, add them to the total and decduct the cose from prev (if affordable)
function build(item, level)
{
	//addMessage( ['building', item, 'at level', level] );
	// lowest smallest item && level, free
	if (item == items_arr[0])	{ 
		itemInc(item, level);
		return;
	}

	var prev = prev_map[item];
	var next_cost = calc(level+1);
	if (item_count_map[prev] >= next_cost) {
		item_count_map[prev] -= next_cost;
		getElement(prev).value = item_count_map[prev];
		itemInc(item, level);
	} else {
		addMessage( ['can\'t build', item+".", 'insufficient', prev_map[item]+"."	, 'have', item_count_map[prev], 'need', next_cost+"."] );
	}
}

// increase an item count by BASE^level items
function itemInc(item, level) {
	var count = item_count_map[item];
	item_count_map[item] +=  calc(level);
	getElement(item).value = item_count_map[item];
}

function itemDec(item, level) {

}

// increase an item build rate but BASE^level items per sec
function rateInc( item, rate ) {
	// lowest level, use own items
	var next;
	if (item == items_arr[items_arr.length-1]) {
		next = item;
	} else {
		next = next_map[item];
	}

	var next_cost = calc( parseInt( rate+1 ) );
	if (next_cost <= parseInt(getElement(next).value)) {
		//addMessage( ['building', item, 'rate increase requires', next_cost, next ] );
		rate_map[item] += calc( parseInt( rate ) );
		item_count_map[next] -= next_cost;
		
		getElement(item + "_rate").value = rate_map[item] + "/s";
		getElement(next).value = item_count_map[next];
	} else {
		addMessage( ['can\'t build', item, 'accelerator. insufficient', next+"."	, 'have', getElement(next).value, 'need', next_cost+"."] );
	}

	//addMessage( [item, getElement(item).value, next_map[item], getElement(next_map[item]).value]);

}