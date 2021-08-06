var modal = document.getElementById('visualizar')

modal.addEventListener('show.bs.modal', function (event) {
	
	var nome  = event.relatedTarget.getAttribute('data-nome');
	var dataNascimento  = event.relatedTarget.getAttribute('data-nascimento');
	var genero  = event.relatedTarget.getAttribute('data-genero');
	var rua  = event.relatedTarget.getAttribute('data-rua');
	var avenida  = event.relatedTarget.getAttribute('data-avenida');
	var numero  = event.relatedTarget.getAttribute('data-numero');
	var cidade  = event.relatedTarget.getAttribute('data-cidade');
	

	modal.querySelector('.modal-nome').textContent = nome;
	modal.querySelector('.modal-genero').textContent= genero;
	modal.querySelector('.modal-nascimento').textContent = dataNascimento;
	modal.querySelector('.modal-rua').textContent = rua;
	modal.querySelector('.modal-avenida').textContent= avenida;
	modal.querySelector('.modal-numero').textContent= numero;
	modal.querySelector('.modal-cidade').textContent= cidade;
});
