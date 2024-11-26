/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function validarFormulario() {

    document.getElementById('nome-error').textContent = '';
    document.getElementById('telefone-error').textContent = '';
    document.getElementById('cpf-error').textContent = '';


    const nome = document.getElementById('nome').value;
    if (nome.length < 3) {
        document.getElementById('nome-error').textContent = 'O nome deve ter pelo menos 3 caracteres.';
        return false;
    }

    // TEL
    const telefone = document.getElementById('telefone').value;
    const telefonePattern = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
    if (!telefonePattern.test(telefone)) {
        document.getElementById('telefone-error').textContent = 'O telefone deve estar no formato (xx) xxxx-xxxx ou (xx) xxxxx-xxxx.';
        return false;
    }

    // CPF
    const cpf = document.getElementById('cpf').value;
    if (!validarCPF(cpf)) {
        document.getElementById('cpf-error').textContent = 'CPF inválido.';
        return false;
    }

    return true;
}

// validar CPF
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');
    if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf))
        return false;

    let soma = 0, resto;
    for (let i = 1; i <= 9; i++)
        soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11)
        resto = 0;
    if (resto !== parseInt(cpf.substring(9, 10)))
        return false;

    soma = 0;
    for (let i = 1; i <= 10; i++)
        soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11)
        resto = 0;
    if (resto !== parseInt(cpf.substring(10, 11)))
        return false;

    return true;
}
