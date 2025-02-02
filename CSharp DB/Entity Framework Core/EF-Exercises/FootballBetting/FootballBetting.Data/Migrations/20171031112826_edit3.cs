using Microsoft.EntityFrameworkCore.Migrations;
using System;
using System.Collections.Generic;

namespace FootballBetting.Data.Migrations
{
    public partial class edit3 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_CountryContinent_Continents_ContinentId",
                table: "CountryContinent");

            migrationBuilder.DropForeignKey(
                name: "FK_CountryContinent_Countries_CountryId",
                table: "CountryContinent");

            migrationBuilder.DropPrimaryKey(
                name: "PK_CountryContinent",
                table: "CountryContinent");

            migrationBuilder.RenameTable(
                name: "CountryContinent",
                newName: "CountriesContinents");

            migrationBuilder.RenameIndex(
                name: "IX_CountryContinent_CountryId",
                table: "CountriesContinents",
                newName: "IX_CountriesContinents_CountryId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_CountriesContinents",
                table: "CountriesContinents",
                columns: new[] { "ContinentId", "CountryId" });

            migrationBuilder.AddForeignKey(
                name: "FK_CountriesContinents_Continents_ContinentId",
                table: "CountriesContinents",
                column: "ContinentId",
                principalTable: "Continents",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_CountriesContinents_Countries_CountryId",
                table: "CountriesContinents",
                column: "CountryId",
                principalTable: "Countries",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_CountriesContinents_Continents_ContinentId",
                table: "CountriesContinents");

            migrationBuilder.DropForeignKey(
                name: "FK_CountriesContinents_Countries_CountryId",
                table: "CountriesContinents");

            migrationBuilder.DropPrimaryKey(
                name: "PK_CountriesContinents",
                table: "CountriesContinents");

            migrationBuilder.RenameTable(
                name: "CountriesContinents",
                newName: "CountryContinent");

            migrationBuilder.RenameIndex(
                name: "IX_CountriesContinents_CountryId",
                table: "CountryContinent",
                newName: "IX_CountryContinent_CountryId");

            migrationBuilder.AddPrimaryKey(
                name: "PK_CountryContinent",
                table: "CountryContinent",
                columns: new[] { "ContinentId", "CountryId" });

            migrationBuilder.AddForeignKey(
                name: "FK_CountryContinent_Continents_ContinentId",
                table: "CountryContinent",
                column: "ContinentId",
                principalTable: "Continents",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_CountryContinent_Countries_CountryId",
                table: "CountryContinent",
                column: "CountryId",
                principalTable: "Countries",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
