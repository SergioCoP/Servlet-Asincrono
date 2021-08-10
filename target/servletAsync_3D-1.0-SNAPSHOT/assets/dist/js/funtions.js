var abrir = document.getElementById('btn-registar');
const cancelButton = document.getElementById('cerrar');
const dialogoregistrar = document.getElementById('Registrar');

(function() {

    // Update button opens a modal dialog
    abrir.addEventListener('click', function() {
        dialogoregistrar.showModal();
    });
    // Form cancel button closes the dialog box
    cancelButton.addEventListener('click', function() {
        dialogoregistrar.close();
    });


})();

const fill = (list) => {
    let table = "";

    if(list.length > 0){
        for(let i = 0; i < list.length; i++) {
            table += `
			<tr>
				<td>${ i + 1 }</td>
				<td><img src="data:image/jpeg;base64,${list[i].imgGame}"></td>
				<td>${list[i].nameGame}</td>
				<td>${list[i].Category_idCategory.nameCategory}</td>
				<td>${list[i].datePremiere}</td>
				<td>${list[i].status ? "Activo" : "Inactivo"}</td>
				<td>
					<button type="button" class="btn btn-info">Ver</button>
					<button type="button" class="btn btn-primary">Modificar</button>
					<button type="button" class="btn btn-danger">Eliminar</button>
				</td>
			</tr>
			`;
        }
    }else{
        table = `
		<tr class="text-center">
			<td colspan="5">No hay registros para mostrar</td>
		</tr>
		`;
    }
    $(`#container > tbody`).html(table);
};

const findAll = () => {
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax({
        type: 'GET',
        url: contextPath + '/readGames',
        data: { }
    }).done(function(res){
        fill(res.listGames);
    });
};
findAll();

/*const create = () => {
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    var txtnames = $('txtname').val();
    var txtimages = $('txtimage');
    var txtdates = $('txtdate').val();
    var txtidCategorys = $('txtidCategory').val();

    $.ajax({
        type: 'POST',
        url: contextPath + '/createGame',
        data: {txtname: txtnames, txtimage: txtimages, txtdate: txtdates, txtidCategory: txtidCategorys }
    });
};*/

$('#fregistrar').submit(function () {
    var obj = {
        txtname: $('txtname').val(),
        txtimage: $('txtimage').val(),
        txtdate: $('txtdate').val(),
        txtidCategory: $('txtidCategory').val()
    };

    registrar(JSON.stringify(obj));
    /*var txtnames = $('txtname').val();
    var txtimages = $('txtimage');
    var txtdates = $('txtdate').val();
    var txtidCategorys = $('txtidCategory').val();*/

});

const registrar = (json) =>{
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax({
        type: 'POST',
        url: contextPath + '/createGame?action=create',
        data: {cat: json },
        success: function(){
            findAll();
        }
    });
}