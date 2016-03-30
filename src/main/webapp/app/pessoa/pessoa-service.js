(function() {

'use strict';


  cadastroSimples.service('pessoaService', function($http) {

    return {
      
      postPessoa: function(params){
        return $http.post('/pessoa', null, params);
      },

      getPerfisFinanceiros: function(){
      	return $http.get(API_URL + '/perfil-financeiro');
      }

    };

  }]);

})(angular);
