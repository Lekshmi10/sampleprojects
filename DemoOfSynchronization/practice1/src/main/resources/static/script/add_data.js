function adding() {
    var q = document.getElementById("q").value;
    var a = document.getElementById("a").value;
    var b = document.getElementById("b").value;
    var c = document.getElementById("c").value;
    var d = document.getElementById("d").value;
    var e = document.getElementById("e").value;
    console.log(a);
    console.log(b);
    console.log(c);
    console.log(d);
    console.log(e);
    console.log(q);
    var data = JSON.stringify({
        "question": q,
        "option_A": a,
        "option_B": b,
        "option_C": c,
        "option_D": d,
        "option_E": e
    });
    console.log(data.toString());
    postApi("app/addDB", data, function (response) {
        if (response === "true") {
            alert("Question added")
        } else {
            alert("questions are not added")
        }


    });

    function postApi(url, reqBody, callback) {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                callback(this.responseText);
                console.log(this.responseText)
            }
        }

        xhr.open('POST', url, true);
        console.log(callback);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(reqBody);
    }

}

function directing() {
    document.getElementById("next").click("index.html");
}

function editing() {
    window.location.href = "/app/getDB"
}


