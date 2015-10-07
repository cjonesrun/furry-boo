/*********************************************************
sets the value of a cookie
**********************************************************/
document.setCookie = function(sName,sValue)
{
    var oDate = new Date();
    oDate.setYear(oDate.getFullYear()+1);
    var sCookie = encodeURIComponent(sName) + '=' + encodeURIComponent(sValue) + ';expires=' + oDate.toGMTString() + ';path=/';
    document.cookie= sCookie;
}

/*********************************************************
gets the value of a cookie
**********************************************************/
document.getCookie = function(sName)
{
    sName = sName.toLowerCase();
    var oCrumbles = document.cookie.split(';');
    for(var i=0; i<oCrumbles.length;i++)
    {
        var oPair= oCrumbles[i].split('=');
        var sKey = decodeURIComponent(oPair[0].trim().toLowerCase());
        var sValue = oPair.length>1?oPair[1]:'';
        if(sKey == sName)
            return decodeURIComponent(sValue);
    }
    return '';
}

/*********************************************************
expires a cookie
**********************************************************/
document.clearCookie = function(sName)
{
    var oDate = new Date();
    oDate.setYear(oDate.getFullYear()-1);
    var sCookie = encodeURIComponent(sName) + '=' + ';expires=' + oDate.toGMTString() + ';path=/';
    document.cookie= sCookie;
}



function initFromCookies() {
    var items = document.getCookie("item_count");
    var rates = document.getCookie("rate_count");

    if (items != null) {
        item_count_map = JSON.parse(items);
        rate_count = JSON.parse(rates);
    }
    setData(starting_interval); // timer.js

}

function saveState()
{
    console.log("cookie item count = ", item_count_map);
    console.log("cookie item rate = ", rate_map );

	document.setCookie("item_count",JSON.stringify(item_count_map));
    document.setCookie("rate_count",JSON.stringify(rate_map));

	console.log("item_count = ", document.getCookie("item_count"));
	console.log("rate_count = ", document.getCookie("rate_count"));

}