document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formulario");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita envio até que as validações sejam feitas

        let isValid = true;

        // Validação do campo Nome do Aluno
        const nomeAluno = document.getElementById("nomeAluno").value.trim();
        const nomeRegex = /^[A-Za-zÀ-ú\s]{3,50}$/; // Letras e espaços de 3 a 50 caracteres

        if (!nomeRegex.test(nomeAluno)) {
            alert("O campo Nome do Aluno deve ter entre 3 e 50 caracteres e não pode conter números ou caracteres especiais.");
            isValid = false;
        }

        // Validação do campo CPF
        const cpfAluno = document.getElementById("cpfAluno").value.trim();
        const cpfRegex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;

        if (!cpfRegex.test(cpfAluno)) {
            alert("CPF inválido. Use o formato XXX.XXX.XXX-XX");
            isValid = false;
        }

        // Validação do campo E-mail
        const emailAluno = document.getElementById("emailAluno").value.trim();
        if (emailAluno.length < 10 || emailAluno.length > 75) {
            alert("O campo E-mail deve ter entre 10 e 75 caracteres.");
            isValid = false;
        }

        if (isValid) {
            form.submit(); // Envia o formulário se todas as validações forem atendidas
        }
    });

    // Adiciona máscara para CPF
    const cpfInput = document.getElementById("cpfAluno");
    cpfInput.addEventListener("input", function () {
        let value = cpfInput.value.replace(/\D/g, ""); // Remove qualquer caractere que não seja número
        value = value.replace(/(\d{3})(\d)/, "$1.$2");
        value = value.replace(/(\d{3})(\d)/, "$1.$2");
        value = value.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
        cpfInput.value = value;
    });
});
