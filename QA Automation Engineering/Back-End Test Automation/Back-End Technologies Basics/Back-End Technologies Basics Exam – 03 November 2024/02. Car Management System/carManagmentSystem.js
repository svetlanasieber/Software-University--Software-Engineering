function solve(cars) {
    
    function getCarsByBrand(brand) {
        return cars.filter(car => car.brand === brand);
    }

    
    function addCar(id, brand, model, year, price, inStock) {
        const newCar = { id, brand, model, year, price, inStock };
        cars.push(newCar);
        return cars;
    }

    
    function getCarById(id) {
        const car = cars.find(car => car.id === id);
        return car ? car : `Car with ID ${id} not found`;
    }

    
    function removeCarById(id) {
        const index = cars.findIndex(car => car.id === id);
        if (index !== -1) {
            cars.splice(index, 1);
            return cars;
        } else {
            return `Car with ID ${id} not found`;
        }
    }

    
    function updateCarPrice(id, newPrice) {
        const car = cars.find(car => car.id === id);
        if (car) {
            car.price = newPrice;
            return cars;
        } else {
            return `Car with ID ${id} not found`;
        }
    }

    
    function updateCarStock(id, inStock) {
        const car = cars.find(car => car.id === id);
        if (car) {
            car.inStock = inStock;
            return cars;
        } else {
            return `Car with ID ${id} not found`;
        }
    }

    return {
        getCarsByBrand,
        addCar,
        getCarById,
        removeCarById,
        updateCarPrice,
        updateCarStock
    };
}
