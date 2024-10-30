// scripts.js

const API_BASE_URL = "http://localhost:8080/gestores"; // URL base da API

// Função para carregar os gerentes no index.html
async function carregarGerentes() {
    try {
        const response = await fetch(API_BASE_URL);
        const gerentes = await response.json();
        const tabela = document.getElementById("gerentes-list");
        tabela.innerHTML = gerentes.map(gerente => `
            <tr>
                <td>${gerente.nome}</td>
                <td>${gerente.cpf}</td>
                <td>${gerente.tel}</td>
                <td>${gerente.email}</td>
                <td>${gerente.cargo}</td>
                <td>${gerente.estaAtivo ? "Sim" : "Não"}</td>
                <td>
                    <button onclick="editarPessoa(${gerente.id})">Editar</button>
                    <button onclick="excluirPessoa(${gerente.id})">Excluir</button>
                </td>
            </tr>
        `).join('');
    } catch (error) {
        console.error("Erro ao carregar os gerentes:", error);
    }
}
function editarPessoa(id) {
    window.location.href = `/editar?id=${id}`;
}

// Função para registrar uma nova pessoa
async function registrarPessoa(event) {
    event.preventDefault(); // Impede o envio padrão do formulário
    const novaPessoa = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        tel: document.getElementById("tel").value,
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value,
        cargo: document.getElementById("cargo").value,
        estaAtivo: document.getElementById("estaAtivo").checked
    };
    
    try {
        const response = await fetch(API_BASE_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(novaPessoa)
        });
        
        if (response.ok) {
            window.location.href = "/"; // Redireciona para a página principal após o registro
        }
    } catch (error) {
        console.error("Erro ao registrar nova pessoa:", error);
    }
}

// Função para carregar dados da pessoa selecionada para edição
async function carregarPessoa(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`);
        const pessoa = await response.json();
        
        document.getElementById("nome").value = pessoa.nome;
        document.getElementById("cpf").value = pessoa.cpf;
        document.getElementById("tel").value = pessoa.tel;
        document.getElementById("email").value = pessoa.email;
        document.getElementById("senha").value = pessoa.senha;
        document.getElementById("cargo").value = pessoa.cargo;
        document.getElementById("estaAtivo").checked = pessoa.estaAtivo;
        
        document.getElementById("editar-form").onsubmit = function(event) {
            event.preventDefault();
            atualizarPessoa(id);
        };
    } catch (error) {
        console.error("Erro ao carregar dados da pessoa:", error);
    }
}

// Função para atualizar dados da pessoa
async function atualizarPessoa(id) {
    const pessoaAtualizada = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        tel: document.getElementById("tel").value,
        email: document.getElementById("email").value,
        senha: document.getElementById("senha").value,
        cargo: document.getElementById("cargo").value,
        estaAtivo: document.getElementById("estaAtivo").checked
    };
    
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(pessoaAtualizada)
        });
        
        if (response.ok) {
            window.location.href = "/"; 
        }
    } catch (error) {
        console.error("Erro ao atualizar pessoa:", error);
    }
}


// Função para excluir uma pessoa
async function excluirPessoa(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, {
            method: "DELETE"
        });
        
        if (response.ok) {
            carregarGerentes(); // Recarrega a lista de gerentes após a exclusão
        }
    } catch (error) {
        console.error("Erro ao excluir pessoa:", error);
    }
}

// Inicializar lista de gerentes na página principal
if (document.getElementById("gerentes-list")) {
    window.onload = carregarGerentes;
}

// Inicializar o registro de pessoa
if (document.getElementById("registro-form")) {
    document.getElementById("registro-form").onsubmit = registrarPessoa;
}

// Carregar dados da pessoa para edição
const urlParams = new URLSearchParams(window.location.search);
const pessoaId = urlParams.get("id");

if (pessoaId && document.getElementById("editar-form")) {
    carregarPessoa(pessoaId);
}
