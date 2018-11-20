# mutantes

Trabalho 1 Tópicos Especiais
BD Mutantes
O Instituto Internacional de Mutantes solicitou o desenvolvimento de um aplicativo CRUD
de mutantes. O aplicativo tem por objetivo cadastrar todos os mutantes encontrados, bem como
permitir consulta rápida dos mesmos.
Requisitos do Sistema
SplashScreen – tela de apresentação do sistema que permite ao desenvolvedor mostrar sua
marca, deve ser mostrada por apenas 3 segundos.
Activity Dashboard – a segunda tela é uma dashboard com botões que devem levar o usuário a
cadastrar novos mutantes, listar todos, pesquisar mutantes por nome ou habilidades, e sair.
Activity de Cadastro – deve permitir ao usuário cadastrar apenas novos mutantes, não permitindo
o cadastro de um mutante de mesmo nome. Além do nome, o usuário deve cadastrar habilidades
conhecidas daquele mutante (podendo ser mais que uma). Por fim, deve permitir que o usuário
possa acessar a ação de gravar o mutante na base, bem como apresentar um AlertDialog
informando o resultado desta operação (se feita com sucesso ou se erro).
Activity Listar Todos – deve mostrar em uma lista o nome dos mutantes atualmente cadastrados.
Ao clicar em um mutante, uma nova activity é mostrada trazendo maiores informações daquele
mutante, todos os campos cadastrados devem ser mostrados (exceto id). A activity de detalhes
deve ainda permitir que o usuário edite detalhes do mutante, atualizando estas informações na
base, ou que exclua este mutante da base.
Activity Pesquisar – deve permitir que o usuário pesquise mutantes por nome ou por uma certa
habilidade. A lista de resposta deve trazer o mutantes daquele nome, caso tenham algum, ou
todos os mutantes que tenham aquela habilidade. A lista de resposta deve apresentar apenas
nomes.
Botão sair – fecha o aplicativo.
Observações
• Qualquer validação necessária fica a cargo dos desenvolvedores, sendo item de desconto
caso alguma validação não seja realizada e apresente um problema para a lógica ou
execução do aplicativo.
• O cadastro de um mutante deve obedecer a todas as restrições necessárias, inclusive o de
retorno de mensagem de Cadastro com Sucesso ou Erro ao Cadastrar.
• Cadastre previamente pelo menos 10 mutantes.
o Utilize o site https://pt.wikipedia.org/wiki/Categoria:Personagens_de_X-Men para
pegar dados de mutantes.
• O valor deste trabalho é de 40% da nota final;
• Pode ser realizado em grupos de 2 ou 3;
• A data da entrega e apresentação/defesa do trabalho está no moodle, e será realizada
durante a aula. Caso uma equipe não compareça na data marcada, automaticamente
receberá a nota 0;
• Para a apresentação/defesa é necessário a participação de todos os integrantes da equipe;
• Não será permitido o desenvolvimento de funcionalidades ou correção de bugs no dia da
defesa.
• Não será tolerado qualquer tipo de cópia, acarretando em nota 0 para todos os integrantes
envolvidos.
• Usar a API 19 (4.4 - KitKat) do Android e simular em smartphone com tela de 4 polegadas,
como o Nexus S.
• Envie um link compartilhando o projeto na nuvem ou link no github para
brawerman@ufpr.br, com o título BD Mutantes. Inclua nome completo e matrícula no
dos integrantes corpo do email.
Critérios de avaliação
• Activity SplashScreen com funcionamento incorreto – perda de 0,5 ponto;
• Activity Dashboard deve possuir botões levando as activities subsequentes de forma
correta e fechando o aplicativo corretamente –0,5 ponto;
• Activity de Cadastro com mutante sendo registrado corretamente e nomes repetidos não
sendo permitidos – 1,0 ponto;
• Activity Listar todos com lista completa de mutantes cadastrados e levando corretamente
a tela de detalhes – 0,5 ponto;
o Activity de Detalhes do mutante mostrando as informações corretamente,
permitindo edição e atualização de dados, além da exclusão de um mutante – 1,0
pontos.
• Activity Pesquisar com funcionamento correto, montando a lista conforme resultado
pesquisado – 1,0 ponto.
