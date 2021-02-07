function getParameterByName(name, idname, url = window.location.href) {
//@routes.HomeController.persons()?limit=getParameterByName("limit")&offset=getParameterByName("offset")
    var i = parseFloat(new URLSearchParams(url).get(name))
    if (idname == "prev" && i > -1){
        if(i == 0)
            return 0;
        return i - 1;
    }
    return parseFloat(new URLSearchParams(url).get(name))+1;
}

function ptr(idname) {
    var prev = document.getElementById(idname);
    prev.setAttribute('href', prev.getAttribute("href")+'?limit=2'+'&offset='+getParameterByName('offset', idname));

}