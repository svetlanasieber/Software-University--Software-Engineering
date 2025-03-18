#nullable disable
namespace DeskMarket.Areas.Identity.Pages.Account
{
    using System.ComponentModel.DataAnnotations;

    using Microsoft.AspNetCore.Authentication;
    using Microsoft.AspNetCore.Identity;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.RazorPages;

    public class LoginModel : PageModel
    {
        private readonly SignInManager<IdentityUser> signInManager;

        public LoginModel(SignInManager<IdentityUser> signInManager) => this.signInManager = signInManager;

        [BindProperty]
        public InputModel Input { get; set; }

        public string ReturnUrl { get; set; }

        [TempData]
        public string ErrorMessage { get; set; }

        public class InputModel
        {
            [Required]
            [EmailAddress]
            public string Email { get; set; }

            [Required]
            [DataType(DataType.Password)]
            public string Password { get; set; }

            public bool RememberMe { get; set; }
        }

        public async Task<IActionResult> OnGetAsync(string returnUrl = null)
        {
            if (this.User?.Identity?.IsAuthenticated ?? false)
            {
                return this.RedirectToAction("Index", "Product");
            }

            if (!string.IsNullOrEmpty(this.ErrorMessage))
            {
                this.ModelState.AddModelError(string.Empty, this.ErrorMessage);
            }

            returnUrl ??= this.Url.Content("~/");
            await this.HttpContext.SignOutAsync(IdentityConstants.ExternalScheme);
            this.ReturnUrl = returnUrl;

            return Page();
        }

        public async Task<IActionResult> OnPostAsync(string returnUrl = null)
        {
            returnUrl ??= Url.Content("~/Product/Index");

            if (this.ModelState.IsValid)
            {
                var result = await this.signInManager.PasswordSignInAsync(
                    this.Input.Email,
                    this.Input.Password,
                    this.Input.RememberMe,
                    lockoutOnFailure: false);

                if (!result.Succeeded)
                {
                    this.ModelState.AddModelError(string.Empty, "Invalid login attempt.");
                    return this.Page();
                }

                return this.LocalRedirect(returnUrl);
            }

            return this.Page();
        }
    }
}
