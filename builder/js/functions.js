function getElement(item)
{
	return document.getElementById(item);
}

// build 10^level items, add them to the total and decduct the cose from prev (if affordable)
function build(item, level)
{
	var element = getElement(item);
	// lowest level, proceed
	if (element.id == items_arr[0])	{ 
		itemInc(element, level);
		return;
	}

	var prev = getElement( prev_map[element.id] );
	var next_cost = Math.pow(BASE,level+1);
	if (prev.value >= next_cost) {
		//console.log( prev.id, prev.value, next_cost );
		prev.value -= next_cost;
		itemInc(element, level);
	} else {
		addMessage( ['can\'t build', item, 'insufficient', prev_map[element.id]+"."	, 'have', prev.value, 'need', next_cost] );
	}
}

// increase an item count by BASE^level items
function itemInc(element, level) {
	var count = parseInt( element.value );
	var x = parseInt( level );
	element.value = Math.pow(BASE,level) + count;
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

	var next_cost = Math.pow(BASE, parseInt( rate+1 ) );
	if (next_cost <= parseInt(getElement(next).value)) {
		//addMessage( ['building', item, 'rate increase requires', next_cost, next ] );
		rate_map[item] += Math.pow(BASE, parseInt( rate ) );
		getElement(item + "_rate").value = rate_map[item] + "/s";
		getElement(next).value = parseInt(getElement(next).value) - next_cost;
	} else {
		addMessage( ['can\'t build', item, 'insufficient', next+"."	, 'have', getElement(next).value, 'need', next_cost] );
	}

	//addMessage( [item, getElement(item).value, next_map[item], getElement(next_map[item]).value]);

}