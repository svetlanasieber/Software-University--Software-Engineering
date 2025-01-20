   SELECT TOP (5) c.CountryName, r.RiverName
     FROM Countries AS c
LEFT JOIN CountriesRivers AS cr ON c.CountryCode = cr.CountryCode
LEFT JOIN Rivers AS r ON cr.RiverId = r.Id
     JOIN Continents AS con ON c.ContinentCode = con.ContinentCode
    WHERE con.ContinentName = 'Africa'
 ORDER BY c.CountryName