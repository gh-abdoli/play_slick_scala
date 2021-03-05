function getParameterByName(name, idname, url = window.location.href) {
    let i = parseFloat(new URLSearchParams(url).get(name))
    if (idname == "prev" && i > -1) {
        if (i == 0)
            return 0;
        return i - 1;
    }
    return parseFloat(new URLSearchParams(url).get(name)) + 1;
}

function ptr(idname) {
    let prev = document.getElementById(idname);
    prev.setAttribute('href', prev.getAttribute("href") + '?limit=2' + '&offset=' + getParameterByName('offset', idname));

}

function modalData() {
    let personId = $('#button-address-Modal').data('whatever');
    $(`#person-id`).val(personId).disable();
}