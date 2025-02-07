// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

// A temperature conversion contract that enables users to convert temperatures between Celsius and Fahrenheit.
// Example: If a user inputs 0°C, toFahrenheit will return 32°F, while inputting 32°F into toCelsius will return 0°C.
// °F = °C × (9/5) + 32. 
contract TemperatureConversion {

    function toFahrenheit(uint256 temp_celsius) external pure returns (uint256 fahrenheit) {
        uint256 factor = 1e18;
        uint256 scale = 9 * factor / 5;
        fahrenheit = temp_celsius * scale / factor + 32;
    }

    function toCelsius(uint256 temp_fahrenheit) external pure returns (uint256 celsius) {
        uint256 factor = 1e18;
        uint256 scale = 9 * factor / 5;
        celsius = temp_fahrenheit / (scale/factor) - 32;
    }
}
