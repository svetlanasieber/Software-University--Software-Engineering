using Microsoft.EntityFrameworkCore.Migrations;
using System;
using System.Collections.Generic;

namespace FootballBetting.Data.Migrations
{
    public partial class edit2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_CountriesContinents_Continents_ContinentId",
                table: "CountriesContinents");

            migrationBuilder.DropForeignKey(
                name: "FK_CountriesContinents_Countries_CountryId1",
                table: "CountriesContinents");

            migrationBuilder.DropPrimaryKey(
                name: "PK_CountriesContinents",
                table: "CountriesContinents");

            migrationBuilder.DropIndex(
                name: "IX_CountriesContinents_CountryId1",
                table: "CountriesContinents");

            migrationBuilder.DropColumn(
                name: "CountryId1",
                table: "CountriesContinents");

            migrationBuilder.RenameTable(
                name: "CountriesContinents",
                newName: "CountryContinent");

            migrationBuilder.AlterColumn<string>(
                name: "CountryId",
                table: "CountryContinent",
                type: "nvarchar(450)",
                nullable: false,
                oldClrType: typeof(int));

            migrationBuilder.AddPrimaryKey(
                name: "PK_CountryContinent",
                table: "CountryContinent",
                columns: new[] { "ContinentId", "CountryId" });

            migrationBuilder.CreateIndex(
                name: "IX_CountryContinent_CountryId",
                table: "CountryContinent",
                column: "CountryId");

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

        protected override void Down(MigrationBuilder migrationBuilder)
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

            migrationBuilder.DropIndex(
                name: "IX_CountryContinent_CountryId",
                table: "CountryContinent");

            migrationBuilder.RenameTable(
                name: "CountryContinent",
                newName: "CountriesContinents");

            migrationBuilder.AlterColumn<int>(
                name: "CountryId",
                table: "CountriesContinents",
                nullable: false,
                oldClrType: typeof(string),
                oldType: "nvarchar(450)");

            migrationBuilder.AddColumn<string>(
                name: "CountryId1",
                table: "CountriesContinents",
                nullable: true);

            migrationBuilder.AddPrimaryKey(
                name: "PK_CountriesContinents",
                table: "CountriesContinents",
                columns: new[] { "ContinentId", "CountryId" });

            migrationBuilder.CreateIndex(
                name: "IX_CountriesContinents_CountryId1",
                table: "CountriesContinents",
                column: "CountryId1");

            migrationBuilder.AddForeignKey(
                name: "FK_CountriesContinents_Continents_ContinentId",
                table: "CountriesContinents",
                column: "ContinentId",
                principalTable: "Continents",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_CountriesContinents_Countries_CountryId1",
                table: "CountriesContinents",
                column: "CountryId1",
                principalTable: "Countries",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
