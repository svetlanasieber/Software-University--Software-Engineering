using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace DeskMarket.Migrations
{
    /// <inheritdoc />
    public partial class AddedIsDeletedPropertyInProductClient : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<bool>(
                name: "IsDeleted",
                table: "ProductsClients",
                type: "bit",
                nullable: false,
                defaultValue: false);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "IsDeleted",
                table: "ProductsClients");
        }
    }
}
