$(document).ready(function () {

    $( "#newsAddButton" ).click(function() {
        newNewsAdd();
    });

});

function newNewsAdd() {
    var news = {}
    news["title"] = $("#titleNews").val();
    news["content"] = $("#contentNews").val();
    news["category"] = $("#categoryNews").val();
    var oMyForm = new FormData();

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/addNews",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(news),
        contentType: "application/json; charset=utf-8",
        dataType: "text",
        success	:function()
        {
            alert("Başarıyla eklendi")
        },

        //error   :Bir hata meydana geldi ise
        error:function()
        {
            alert("Eklenemedi");
        }

    });
}

