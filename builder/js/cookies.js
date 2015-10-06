/*********************************************************
sets the value of a cookie
**********************************************************/
document.setCookie = function(sName,sValue)
{
    var oDate = new Date();
    oDate.setYear(oDate.getFullYear()+1);
    var sCookie = encodeURIComponent(sName) + '=' + encodeURIComponent(sValue) + ',expires=' + oDate.toGMTString() + ',path=/';

    document.cookie= sCookie;
    //alert("Your Cookie : " + document.cookie);
}

/*********************************************************
gets the value of a cookie
**********************************************************/
document.getCookie = function(sName)
{
    sName = sName.toLowerCase();
    var oCrumbles = document.cookie.split(',');
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
removes the value of a cookie
**********************************************************/
document.clearCookie = function(sName)
{
    document.setCookie(sName,'');
}

function saveState()
{
	console.log("cookie X = ", document.getCookie("X"));
	document.setCookie("X","YYYYY");
	console.log("cookie X = ", document.getCookie("X"));
	document.clearCookie("X");
	console.log("cookie X = ", document.getCookie('X'));
}