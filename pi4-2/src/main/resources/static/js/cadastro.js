document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formulario");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita o envio padrão do formulário

        // Criação do objeto com os dados do formulário
        const gestorData = {
            tipo: document.getElementById("tipo").value.trim(),
            nome: document.getElementById("nome").value.trim(),
            cpf: document.getElementById("cpf").value.trim(),
            email: document.getElementById("email").value.trim(),
            telefone: document.getElementById("telefone").value.trim(),
            senha: document.getElementById("senha").value.trim(),
            nomeResponsavel: document.getElementById("nomeResponsavel").value.trim(),
            cpfResponsavel: document.getElementById("cpfResponsavel").value.trim(),
            emailResponsavel: document.getElementById("emailResponsavel").value.trim(),
            telefoneResponsavel: document.getElementById("telefoneResponsavel").value.trim()
        };

        // Envio dos dados para o endpoint usando fetch
        fetch("/gestores", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(gestorData)
        })
        .then(response => {
            if (response.ok) {
                alert("Cadastro realizado com sucesso!");
                form.reset(); // Limpa o formulário após o envio bem-sucedido
            } else {
                alert("Erro ao cadastrar. Por favor, tente novamente.");
            }
            return response.json();
        })
        .catch(error => {
            console.error("Erro ao enviar os dados:", error);
            alert("Erro ao conectar ao servidor.");
        });
    });
});
