window.addEventListener("load", function () {
    window.location != window.parent.location && (document.getElementById("nav_home").style.visibility = "hidden");
    var e = new XMLHttpRequest;
    e.withCredentials = !0, e.addEventListener("readystatechange", function () {
        4 === this.readyState && populate_applications(this.responseText)
    }), e.open("GET", "/app/getDB"), e.send()
});
populate_applications = function (o) {
    //console.log(o.toString())
    let result = JSON.parse(o);
    //document.getElementById("q").innerHTML=result.question;
    document.getElementById("q").value = result.question;
    // console.log()


}