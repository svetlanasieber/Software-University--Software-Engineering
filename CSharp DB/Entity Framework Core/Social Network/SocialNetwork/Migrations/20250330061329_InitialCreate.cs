using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace SocialNetwork.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Conversations",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Title = table.Column<string>(type: "nvarchar(30)", maxLength: 30, nullable: false),
                    StartedAt = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Conversations", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Users",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Username = table.Column<string>(type: "nvarchar(20)", maxLength: 20, nullable: false),
                    Email = table.Column<string>(type: "nvarchar(60)", maxLength: 60, nullable: false),
                    Password = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Users", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Friendships",
                columns: table => new
                {
                    UserOneId = table.Column<int>(type: "int", nullable: false),
                    UserTwoId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Friendships", x => new { x.UserOneId, x.UserTwoId });
                    table.ForeignKey(
                        name: "FK_Friendships_Users_UserOneId",
                        column: x => x.UserOneId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Friendships_Users_UserTwoId",
                        column: x => x.UserTwoId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Messages",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Content = table.Column<string>(type: "nvarchar(200)", maxLength: 200, nullable: false),
                    SentAt = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Status = table.Column<int>(type: "int", nullable: false),
                    ConversationId = table.Column<int>(type: "int", nullable: false),
                    SenderId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Messages", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Messages_Conversations_ConversationId",
                        column: x => x.ConversationId,
                        principalTable: "Conversations",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Messages_Users_SenderId",
                        column: x => x.SenderId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Posts",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Content = table.Column<string>(type: "nvarchar(300)", maxLength: 300, nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "datetime2", nullable: false),
                    CreatorId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Posts", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Posts_Users_CreatorId",
                        column: x => x.CreatorId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "UsersConversations",
                columns: table => new
                {
                    UserId = table.Column<int>(type: "int", nullable: false),
                    ConversationId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_UsersConversations", x => new { x.UserId, x.ConversationId });
                    table.ForeignKey(
                        name: "FK_UsersConversations_Conversations_ConversationId",
                        column: x => x.ConversationId,
                        principalTable: "Conversations",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_UsersConversations_Users_UserId",
                        column: x => x.UserId,
                        principalTable: "Users",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.InsertData(
                table: "Conversations",
                columns: new[] { "Id", "StartedAt", "Title" },
                values: new object[,]
                {
                    { 1, new DateTime(2025, 2, 24, 14, 30, 0, 0, DateTimeKind.Unspecified), "Project Discussion" },
                    { 2, new DateTime(2025, 2, 22, 18, 0, 0, 0, DateTimeKind.Unspecified), "Weekend Plans" },
                    { 3, new DateTime(2025, 2, 23, 10, 15, 0, 0, DateTimeKind.Unspecified), "Team Meeting" },
                    { 4, new DateTime(2025, 1, 31, 16, 23, 0, 0, DateTimeKind.Unspecified), "Movie Night" },
                    { 5, new DateTime(2024, 8, 10, 20, 11, 0, 0, DateTimeKind.Unspecified), "BackUp Group" },
                    { 6, new DateTime(2024, 8, 10, 14, 0, 0, 0, DateTimeKind.Unspecified), "Study Group" }
                });

            migrationBuilder.InsertData(
                table: "Users",
                columns: new[] { "Id", "Email", "Password", "Username" },
                values: new object[,]
                {
                    { 1, "john@example.com", "Pass123", "john_doe" },
                    { 2, "jane@example.com", "Secure456", "jane_doe" },
                    { 3, "alex_sm@mail.com", "TestPass789", "alex_smith" },
                    { 4, "sara_m@mail.com", "MillerPass99", "sara_miller" },
                    { 5, "michael_b@mail.com", "BrownSecret88", "michael_brown" },
                    { 6, "emily_w@mail.com", "EmilyW12345", "emily_white" },
                    { 7, "david_j@mail.com", "JacksonD777", "david_jackson" },
                    { 8, "olivia_t@mail.com", "TaylorOlivia12", "olivia_taylor" },
                    { 9, "william_c@mail.com", "ClarkWill99", "william_clark" }
                });

            migrationBuilder.InsertData(
                table: "Friendships",
                columns: new[] { "UserOneId", "UserTwoId" },
                values: new object[,]
                {
                    { 1, 2 },
                    { 1, 3 },
                    { 1, 7 },
                    { 1, 9 },
                    { 2, 3 },
                    { 2, 4 },
                    { 2, 5 },
                    { 2, 8 },
                    { 3, 4 },
                    { 3, 5 },
                    { 3, 6 },
                    { 3, 8 },
                    { 4, 1 },
                    { 4, 6 },
                    { 5, 7 },
                    { 5, 8 },
                    { 6, 8 },
                    { 7, 9 },
                    { 8, 9 },
                    { 9, 2 }
                });

            migrationBuilder.InsertData(
                table: "UsersConversations",
                columns: new[] { "ConversationId", "UserId" },
                values: new object[,]
                {
                    { 1, 1 },
                    { 3, 1 },
                    { 4, 1 },
                    { 1, 2 },
                    { 2, 2 },
                    { 3, 2 },
                    { 4, 2 },
                    { 6, 2 },
                    { 1, 3 },
                    { 3, 3 },
                    { 3, 4 },
                    { 5, 4 },
                    { 6, 4 },
                    { 3, 5 },
                    { 5, 5 },
                    { 2, 6 },
                    { 3, 6 },
                    { 6, 6 },
                    { 1, 7 },
                    { 3, 7 },
                    { 2, 8 },
                    { 3, 8 }
                });

            migrationBuilder.InsertData(
                table: "UsersConversations",
                columns: new[] { "ConversationId", "UserId" },
                values: new object[,]
                {
                    { 6, 8 },
                    { 1, 9 },
                    { 3, 9 },
                    { 5, 9 }
                });

            migrationBuilder.CreateIndex(
                name: "IX_Friendships_UserTwoId",
                table: "Friendships",
                column: "UserTwoId");

            migrationBuilder.CreateIndex(
                name: "IX_Messages_ConversationId",
                table: "Messages",
                column: "ConversationId");

            migrationBuilder.CreateIndex(
                name: "IX_Messages_SenderId",
                table: "Messages",
                column: "SenderId");

            migrationBuilder.CreateIndex(
                name: "IX_Posts_CreatorId",
                table: "Posts",
                column: "CreatorId");

            migrationBuilder.CreateIndex(
                name: "IX_UsersConversations_ConversationId",
                table: "UsersConversations",
                column: "ConversationId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Friendships");

            migrationBuilder.DropTable(
                name: "Messages");

            migrationBuilder.DropTable(
                name: "Posts");

            migrationBuilder.DropTable(
                name: "UsersConversations");

            migrationBuilder.DropTable(
                name: "Conversations");

            migrationBuilder.DropTable(
                name: "Users");
        }
    }
}
