var app = angular.module('MyApp', ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'partials/allpersons.html',
            controller: 'DefaultController',
            controllerAs: 'ctrl'
        });
        $routeProvider.when('/:id', {
            templateUrl: 'partials/singleperson.html',
            controller: 'SingleController',
            controllerAs: 'ctrl'
        });
        $routeProvider.otherwise({
            redirectTo: '/home'
        });
    }]);

app.controller('DefaultController', ['$scope', '$http', function ($scope, $http) {
        var self = this;
        self.selectedPerson = '';
        self.persons = [
            {id: 1, name: "Jens", age: "18"},
            {id: 2, name: "Peter", age: "23"},
            {id: 3, name: "Hanne", age: "23"}
        ];

        self.loadInfo = function (id) {
            for (var i = 0; i < self.persons.length; i++) {
                if (self.persons[i].id == id) {
                    self.selectedPerson = self.persons[i];
                    console.log(self.persons[i]);
                }
            }
        };
    }]);

app.controller('SingleController', ['$scope', '$routeParams', function ($scope, $routeParams) {


        var self = this;
        self.single = '';
        self.persons = [
            {id: 1, name: "Jens", age: "18"},
            {id: 2, name: "Peter", age: "23"},
            {id: 3, name: "Hanne", age: "23"}
        ];

        for (var i = 0; i < self.persons.length; i++) {
            if (self.persons[i].id == $routeParams.id) {
                self.single = self.persons[i];
                console.log(self.single);

            }
        }



    }]);