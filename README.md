# Netflix Clone Android App

Este é um projeto de clone do Netflix para Android que utiliza a API externa [StackMobile](https://stackmobile.com.br/filmes) para obter informações sobre filmes e séries. O aplicativo inclui autenticação utilizando Firebase Authentication, permitindo aos usuários criar contas, fazer login, deslogar e excluir suas contas. Além disso, o aplicativo possui uma funcionalidade de criação de listas de reprodução, implementada com um `Adapter` personalizado, utiliza `Glide` para carregamento eficiente de imagens, `Retrofit` para realizar chamadas à API e `putExtra` para passar dados entre atividades.


# imagem do app
<div align="center">
 <img src="https://github.com/herickkgb/App-de-filmes/blob/main/app/src/main/res/imagensApp/splash.png?raw=true" width="150">
 <img src="https://github.com/herickkgb/App-de-filmes/blob/main/app/src/main/res/imagensApp/login.png?raw=true" width="150">
 <img src="https://github.com/herickkgb/App-de-filmes/blob/main/app/src/main/res/imagensApp/telaInicial.png?raw=true" width="150">
 <img src="https://github.com/herickkgb/App-de-filmes/blob/main/app/src/main/res/imagensApp/descricao.png?raw=true" width="150">
</div>

## Funcionalidades Principais

1. **Autenticação Firebase:**
   - Criar uma conta utilizando o Firebase Authentication.
   - Fazer login na conta criada.
   - Deslogar da conta.

2. **Gerenciamento de Conta:**
   - Excluir a conta do usuário.

3. **Integração com API Externa (StackMobile):**
   - Utilização da API externa [StackMobile](https://stackmobile.com.br/filmes) para obter informações sobre filmes e séries, como título, descrição, e imagens de capa.
   - Retrofit para realizar chamadas à API.

4. **Listas de Reprodução:**
   - Criar listas de reprodução personalizadas.
   - Utilizar `putExtra` para passar dados entre atividades, permitindo a adição de itens à lista de reprodução.

5. **Adapter Personalizado:**
   - Implementação de um `Adapter` personalizado utilizando `Glide` para carregar imagens de maneira eficiente.

6. **Tratamento de Exceções:**
   - Implementação de tratamento de exceções para lidar com possíveis erros durante as operações.

## Tecnologias Utilizadas

- **Firebase Authentication:** Para autenticação de usuários.
- **API Externa (StackMobile):** Para obter informações sobre filmes e séries.
- **Retrofit:** Para realizar chamadas à API.
- **Glide:** Para carregamento eficiente de imagens.
- **RecyclerView:** Para exibir listas de reprodução com eficiência.
- **Intent e putExtra:** Para passar dados entre atividades.
- **Tratamento de Exceções:** Para lidar com situações de erro durante as operações.

## Configuração do Projeto

1. **Configuração do Firebase:**
   - Configure o Firebase no projeto e ative a autenticação por e-mail.
   - Configure as regras de segurança no Firebase Realtime Database conforme necessário.

2. **Chave da API Externa (StackMobile):**
   - Não é necessário uma chave de API para a [API StackMobile](https://stackmobile.com.br/filmes).

3. **Configuração do Retrofit:**
   - Adicione as dependências do Retrofit no arquivo `build.gradle` do módulo do aplicativo.

```gradle
// build.gradle (Módulo do app)

implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```

4. **Configuração do Projeto Android:**
   - Adicione a dependência do Glide no arquivo `build.gradle` do módulo do aplicativo.

```gradle
// build.gradle (Módulo do app)

implementation 'com.github.bumptech.glide:glide:4.12.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
```

5. **Configuração da Chave da API Externa (StackMobile):**
   - Nenhuma chave de API é necessária para a [API StackMobile](https://stackmobile.com.br/filmes).

## Executando o Projeto

Clone o repositório e abra o projeto no Android Studio. Certifique-se de ter configurado corretamente o Firebase no projeto, adicionado a dependência do Retrofit e do Glide. Após configurar todas as dependências, execute o aplicativo em um emulador ou dispositivo Android.

Este projeto foi desenvolvido como uma prática educacional e pode ser modificado e expandido conforme necessário. Certifique-se de respeitar os termos de serviço da API externa e do Firebase ao usar este projeto.
