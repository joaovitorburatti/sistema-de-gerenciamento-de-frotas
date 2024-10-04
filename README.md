# Sistema de Gerenciamento de Frotas

Este projeto é um sistema simples para gerenciamento de frotas de veículos, permitindo cadastrar, listar, pesquisar e remover veículos. Ele foi desenvolvido em Java e segue uma arquitetura com separação em camadas (View e Service).

## Funcionalidades

📋 *Menu do Sistema:*
1. *Cadastrar Novo Veículo*  
   Permite cadastrar carros ou motos com as seguintes informações:
   - Modelo
   - Marca
   - Ano de Fabricação
   - Placa
   - Número de portas (para carros)
   - Partida elétrica (para motos)

2. *Listar Todos os Veículos Cadastrados*  
   Exibe todos os veículos cadastrados ordenados pelo modelo.

3. *Pesquisar um Veículo por Placa*  
   Permite buscar um veículo específico pela placa.

4. *Remover um Veículo*  
   Remove um veículo da lista utilizando sua placa.

5. *Sair do Sistema*  
   Finaliza o programa.

## Regras de Negócio

- Não é permitido cadastrar veículos com os campos em branco.
- Não é permitido cadastrar veículos com o ano "0".
- Não é permitido cadastrar veículos com o número de portas "0" (para carros).
- Não é permitido o cadastro de dois veículos com a mesma placa.
