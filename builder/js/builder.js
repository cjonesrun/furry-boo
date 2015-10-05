var div = document.getElementById('items_div');
var html = '';

html+='<p>';

html += "# name item_count building/s buildin_next_level/s</p><p>";

for (var i=0; i < items_arr.length; i++) {
    html +=  i+". " + items_arr[i]+'&nbsp;';
    
    html += "<input type=text value=0 id='"+ items_arr[i] + "' size=15>&nbsp;";
    html += "<input type=text value='0/s' id='" + items_arr[i] + "_rate' size=15>";
    html += "<input type=text value='0/s' id='" + items_arr[i] + "_build_rate' size=15>";

    for (var j=0; j < levels_per_item; j++) {
		html += "<input type=\"button\" onclick=\"build( '" + items_arr[i] + "', "+ j +" );\" value=\"" + calc(j) +"\">";

	}

	for (var j=0; j < levels_per_item; j++) {
		html += "<input type=\"button\" onclick=\"rateInc('" + items_arr[i] + "', "+ j +");\" value='" + calc(j) +"/s'>";
	}

    html += "<br>";


    html += "";
}
html+='</p>';
div.innerHTML+= html;