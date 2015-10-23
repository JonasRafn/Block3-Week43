var carApp = angular.module('CarApp', ['ngRoute ']);

carApp.config(function ($routeProvider) {
    $routeProvider
            .when("/", {
                templateUrl: "views/allCars.html",
                controller: "ViewCarController"
            })
            .when("/addEdit/:id/", {
                templateUrl: "views/addEditCar.html",
                controller: "NewCarController"
            })
            .when("/addEdit/", {
                templateUrl: "views/addEditCar.html",
                controller: "NewCarController"
            })
            .otherwise({
                redirectTo: "/"
            });
});


carApp.controller("StaticDataController", ['$scope', function ($scope) {
        var self = this;
        self.title = "Cars Demo App with Routes";
    }
]);

carApp.factory('CarFactory', function () {
    var self = this;
    var cars;
    
    $http.get("/carsv1solution/api/car").then(function (res) {
        self.cars = res.data;
    });

    self.nextId = 5;

    self.getCars = function () {
        return self.cars;
    };

    self.deleteCar = function (id) {
        for (var i = 0; i < self.cars.length; i++) {
            if (self.cars[i].id === id) {
                self.cars.splice(i, 1);
                return;
            }
        }
    };

    self.addEditCar = function (newcar) {
        if (newcar.id == null) {
            newcar.id = self.nextId++;
            self.cars.push(newcar);
        } else {
            for (var i = 0; i < self.cars.length; i++) {
                if (self.cars[i].id === newcar.id) {
                    self.cars[i] = newcar;
                    break;
                }
            }
        }
    };

    return {
        getCars: getCars,
        deleteCar: deleteCar,
        addEditCar: addEditCar
    };

});

carApp.controller('ViewCarController', ["CarFactory", function (CarFactory) {
        var self = this;
        self.cars = CarFactory.getCars();
        self.predicate = "year";
        self.deleteCar = function (id) {
            CarFactory.deleteCar(id);
        };
    }
]);

carApp.controller('NewCarController', ['CarFactory', '$routeParams', function (CarFactory, $routeParams) {
        var self = this;
        self.saveCar = function () {
            CarFactory.addEditCar(self.newcar);
            self.newcar = {};
        };

        var cars = CarFactory.getCars();
        for (var i = 0; i < cars.length; i++) {
            if (cars[i].id == $routeParams.id) {
                self.newcar = angular.copy(cars[i]);
            }
        }

    }]);