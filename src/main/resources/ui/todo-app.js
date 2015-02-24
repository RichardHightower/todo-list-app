function httpGet(theUrl)
    {
        var xmlHttp = null;

        xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", theUrl, false );
        xmlHttp.send( null );
        return xmlHttp.responseText;
    }



//button
//var newItem = document.getElementById("add");

//submit text box
var enterItem = document.getElementById("enteritem");
enterItem.focus();

enterItem.onkeyup = function(event) {

// 13 represents the enter key.
    if (event.which == 13) {



    //var enterItem = event.which;
    var itemContent = enterItem.value;
    //var itemContent = event.which;
    if (!itemContent || itemContent == "" || itemContent == " " || itemContent == "  ") {
        return false;
    }
    addNewItem(document.getElementById("todolist"), itemContent);

    enterItem.focus();
    enterItem.select();
        }
}

function removeItem() {
        //var listId = this.id.replace("li_", "");
        document.getElementById(this.id).style.display = "none";


    }


function addNewItem(list, itemContent) {

       var date = new Date();
       var id = "" + date.getHours() + date.getMinutes() + date.getSeconds() + date.getMilliseconds();

       var listItem = document.createElement("li");
       listItem.id = "li_" + id;
       var checkBox = document.createElement("input");
       checkBox.type = "checkBox";
       checkBox.id = "idc_" + id;


       var span = document.createElement("span");
       span.id = "ids_" + id;

       checkBox.onclick = itemStatus;

       span.innerText = itemContent;
       listItem.ondblclick = removeItem;

       listItem.appendChild(checkBox);
       listItem.appendChild(span);


    //listItem.textContent = itemContent;
    list.appendChild(listItem);


}

function itemStatus() {
    var checkboxId = this.id.replace("idc_", "");
    var itemContent = document.getElementById("ids_" + checkboxId);

    if (this.checked){

        itemContent.className = "check";

    }else {
         itemContent.className = "";



    }
    

}