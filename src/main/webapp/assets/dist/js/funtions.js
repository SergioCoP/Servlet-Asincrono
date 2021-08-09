$(document).ready(function () {
   $.getJSON("/readGames",function (map){
       var table = $('#table');
       $.each(map,function (index, data) {
           $('<tr>').appendTo(table)
               .append($('<td>').text(data.idGame))
               .append($('<td>').text(data.gameName))
               .append($('<td>').append($('')))
       })
   })
});