var tx = document.getElementById('messages');
tx.value = document.cookie;

var div = document.getElementById('items_div');
var html = '';

html+='<p><table border=0><tr> <th>#</th> <th>name</th> <th>item_count</th> <th>accumulate/s</th> <th>build/s</th>';

for (var j=0; j < levels_per_item*2; j++) {
    html += '<th></th> ';
}

for (var i=0; i < items_arr.length; i++) {

    html += '<tr><td>' +i+"</td> <td>" + items_arr[i]+'</td>';
    
    html += "<td><input type=text value=0 id='"+ items_arr[i] + "' size=15></td>";
    html += "<td><input type=text value='0/s' id='" + items_arr[i] + "_rate' size=15></td>";
    html += "<td><input type=text value='0/s' id='" + items_arr[i] + "_build_rate' size=15></td>";

    for (var j=0; j < levels_per_item; j++) {
        if (i==0 && j==0 || i>0) // hide all add buttons for item[0]
            html += "<td><input type=\"button\" onclick=\"build( '" + items_arr[i] + "', "+ j +" );\" value=\"" + calc(j) +"\">";        
        else
            html += "<td></td>";
	}

	for (var j=0; j < levels_per_item; j++) {
		html += "<td><input type=\"button\" onclick=\"rateInc('" + items_arr[i] + "', "+ j +");\" value='" + calc(j) +"/s'></td>";
	}
    html+=' </tr>';
}

html+='</table>';
html+='</p>';

div.innerHTML+= html;