// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#tbusuarios').DataTable();
});


async function cargarUsuarios(){

      const respuesta = await fetch('usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await respuesta.json();

      let listadoHtml= '';
      for (let usr of usuarios) {
        let usuarioHtml = '<tr> <td>'+usr.id+'</td> <td>'+usr.nombre+'</td> <td>'+usr.apellido+'</td> <td>'+usr.telefono+'</td> <td>'+usr.correo+'</td> <td> <a href="#" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i> </a> </td> </tr>';

        listadoHtml += usuarioHtml;
        
      }

      console.log('usuarios');
      console.log(usuarios);
      
      document.querySelector('#tbusuarios tbody').outerHTML = listadoHtml;
}
