const userSave = () => {
	let id = $("#id").val();
	let name = $("#name").val();
	let email = $("#email").val();
	let password = $("#password").val();
	let login = $("#login").val();
	let cpf = $("#cpf").val();

	if (name.length == 0 || email.length == 0 || password.length == 0 || login.length == 0 || cpf.length == 0) {
		alert('Este campo não pode estar vazio');
	}
	else if (name.length < 5 || name.length > 100) {
		alert('O campo "Name" deve ser inserido no minimo 5 caracteres, e no maximo 100');
	}
	else if (email.length < 10 || email.length > 150) {
		alert('O campo "Email" deve ser inserido no minimo 10 caracteres, e no maximo 150');
	}
	else if (login.length < 5 || login.length > 80) {
		alert('O campo "Login" deve ser inserido no minimo 5 caracteres, e no maximo 80');
	}
	else if (password.length < 8 || email.length > 50) {
		alert('O campo "Password" deve ser inserido no minimo 8 caracteres, e no maximo 50');
	}
	else if (cpf.length < 11) {
		alert('O campo "cpf" deve ter 11 caracteres');
	}
	else {
		$.ajax({
			method: "POST",
			url: "http://localhost:8080/SpringUser/api/v1/estoque",
			data: JSON.stringify({
				id: id,
				name: name,
				login: login,
				senha: password,
				email: email,
				cpf: cpf
			}),
			contentType: "application/json; charset-utf-8",
			success: function(response) {
				alert('Usuário cadastrado com sucesso');				
			}
		}).fail(function(xhr, status, errorThrow) {
			alert("Erro ao salvar: " + xhr.responseText + ", Status:" + status.responseText);
		});
	}
}

const findAllUser = () => {

	window.onload = (event) => {
		$.ajax({
			method: "GET",
			url: "http://localhost:8080/SpringUser/api/v1/estoque",
			contentType: "application/json; charset-utf-8",
			timeout: 0
		}).done(function(response) {
			tableGenerator(response);
		});
	}
}

const tableGenerator = users => {
	let tbody = document.getElementById("tbody");


	users.forEach((user) => {
		let linha = document.createElement("tr");
		let tbody = document.getElementById("tbody");
		let colunaId = document.createElement("td");
		let colunaName = document.createElement("td");
		let colunaLogin = document.createElement("td");
		let colunaSenha = document.createElement("td");
		let colunaEmail = document.createElement("td");
		let colunaCpf = document.createElement("td");
		let buttonEdit = document.createElement("button");
		let buttonDelete = document.createElement("button");

		buttonEdit.setAttribute('id', 'buttonEdit');
		buttonEdit.setAttribute('onclick', `startEdit(${user.id})`);
		buttonDelete.setAttribute('id', 'buttonDelete');
		buttonDelete.setAttribute('onclick', `deleteUser(${user.id})`);		
		//buttonDelete.addEventListener('click', deleteUser(user.id));

		colunaId.innerHTML = user.id;
		colunaName.innerHTML = user.name;
		colunaLogin.innerHTML = user.login;
		colunaSenha.innerHTML = user.senha;
		colunaEmail.innerHTML = user.email;
		colunaCpf.innerHTML = user.cpf;

		buttonEdit.appendChild(document.createTextNode("Edit"));
		buttonDelete.appendChild(document.createTextNode("Delete"));

		tbody.appendChild(linha);
		linha.appendChild(colunaId);
		linha.appendChild(colunaName);
		linha.appendChild(colunaLogin);
		linha.appendChild(colunaSenha);
		linha.appendChild(colunaEmail);
		linha.appendChild(colunaCpf);
		linha.appendChild(buttonEdit);
		linha.appendChild(buttonDelete);
	});
}

const startEdit = (id) => {
	let buttonUpdate = document.getElementById("buttonUpdate");
	buttonUpdate.removeAttribute("disabled");
	let buttonSave = document.getElementById("button");
	//buttonSave.atsetAttribute('disabled', 'true');
	
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/SpringUser/api/v1/estoque/" + id,
		contentType: "application/json; charset-utf-8",
	}).done(function(response) {
		$("#id").val(response.id);
		$("#name").val(response.name);
		$("#email").val(response.email);
		$("#password").val(response.senha);
		$("#login").val(response.login);
		$("#cpf").val(response.cpf);
	});
}

const deleteUser = (id) => {
	
	$.ajax({
		method: "DELETE",
		url: "http://localhost:8080/SpringUser/api/v1/estoque/"+id,
		data: JSON.stringify({
			id: id
		}),
		success: function(response) {
			alert("Deletado com sucesso");
			window.location.reload(false); 

		}
	}).fail(function(xhr, status, errorThrow) {
		alert("Erro ao deletar: " + xhr.responseText + ", Status:" + status.responseText);
	});
}

const updateUser = () => {
	let id = $("#id").val();
	let name = $("#name").val();
	let email = $("#email").val();
	let password = $("#password").val();
	let login = $("#login").val();
	let cpf = $("#cpf").val();

	if (name.length == 0 || email.length == 0 || password.length == 0 || login.length == 0 || cpf.length == 0) {
		alert('Este campo não pode estar vazio');
	}
	else if (name.length < 5 || name.length > 100) {
		alert('O campo "Name" deve ser inserido no minimo 5 caracteres, e no maximo 100');
	}
	else if (email.length < 10 || email.length > 150) {
		alert('O campo "Email" deve ser inserido no minimo 10 caracteres, e no maximo 150');
	}
	else if (login.length < 5 || login.length > 80) {
		alert('O campo "Login" deve ser inserido no minimo 5 caracteres, e no maximo 80');
	}
	else if (password.length < 8 || email.length > 50) {
		alert('O campo "Password" deve ser inserido no minimo 8 caracteres, e no maximo 50');
	}
	else if (cpf.length < 11) {
		alert('O campo "cpf" deve ter 11 caracteres');
	}
	else {
		$.ajax({
			method: "PUT",
			url: "http://localhost:8080/SpringUser/api/v1/estoque/" + id,
			data: JSON.stringify({
				id: id,
				name: name,
				login: login,
				senha: password,
				email: email,
				cpf: cpf
			}),
			contentType: "application/json; charset-utf-8",
			success: function(response) {
				alert("Atualizado com sucesso");				
			}
		}).fail(function(xhr, status, errorThrow) {
			alert("Erro ao atualizar: " + xhr.responseText + ", Status:" + status.responseText);
		});
	}
}
findAllUser();

//event.preventDefault();
