namespace DeskMarket.Controllers
{
    using AutoMapper;
    using DeskMarket.Common.Extensions;
    using DeskMarket.Models.Product;
    using DeskMarket.Services.Category;
    using DeskMarket.Services.Product;
    using DeskMarket.Services.Product.Models;
    using Microsoft.AspNetCore.Authorization;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;

    [Authorize]
    public class ProductController : Controller
    {
        private readonly IProductService productService;
        private readonly ICategoryService categoryService;
        private readonly IMapper mapper;

        public ProductController(
            IProductService productService,
            ICategoryService categoryService,
            IMapper mapper)
        {
            this.categoryService = categoryService;
            this.productService = productService;
            this.mapper = mapper;
        }

        [HttpGet]
        [AllowAnonymous]
        public async Task<IActionResult> Index()
        {
            var serviceModels = await this.productService.GetAllAsync();
            return this.View(serviceModels);
        }

        [HttpGet]
        public async Task<IActionResult> Add()
        {
            var viewModel = new ProductFormModel();
            await this.LoadCategoriesAsync(viewModel);
            return this.View(viewModel);
        }

        [HttpPost]
        public async Task<IActionResult> Add(ProductFormModel viewModel)
        {
            if (!this.ModelState.IsValid)
            {
                await this.LoadCategoriesAsync(viewModel);
                return this.View(viewModel);
            }

            var serviceModel = this.mapper.Map<ProductServiceModel>(viewModel);
            serviceModel.SellerId = this.User.GetId()!;
            await this.productService.CreateAsync(serviceModel);

            return this.RedirectToAction(nameof(Index));
        }

        [HttpGet]
        [AllowAnonymous]
        public async Task<IActionResult> Details(int id)
        {
            var userId = this.User.GetId();
            var model = await this.productService.GetDetailsModelAsync(userId, id);

            if (model == null)
            {
                return this.NotFound();
            }

            return this.View(model);
        }

        [HttpGet]
        public async Task<IActionResult> Edit(int id)
        {
            var serviceModel = await this.productService.GetModelByIdAsync(id);

            if (serviceModel == null)
            {
                return this.NotFound();
            }

            if (this.User.GetId() != serviceModel.SellerId)
            {
                return this.Unauthorized();
            }

            var viewModel = this.mapper.Map<ProductFormModel>(serviceModel);
            await this.LoadCategoriesAsync(viewModel);
            return this.View(viewModel);
        }

        [HttpPost]
        public async Task<IActionResult> Edit(int id, ProductFormModel viewModel)
        {
            if (!this.ModelState.IsValid)
            {
                await this.LoadCategoriesAsync(viewModel);
                return this.View(viewModel);
            }

            var serviceModel = this.mapper.Map<ProductServiceModel>(viewModel);
            serviceModel.Id = id;
            await this.productService.EditAsync(serviceModel);

            return this.RedirectToAction(nameof(Details), new { id });
        }

        [HttpGet]
        public async Task<IActionResult> Delete(int id)
        {
            var currentUserId = this.User.GetId();
            var serviceModel = await this.productService.GetDetailsModelAsync(currentUserId, id);

            if (serviceModel == null)
            {
                return this.NotFound();
            }

            if (currentUserId != serviceModel.SellerId)
            {
                return this.Unauthorized();
            }

            return this.View(serviceModel);
        }

        [HttpPost]
        [ActionName(nameof(Delete))]
        public async Task<IActionResult> DeletePost(int id)
        {
            await this.productService.DeleteAsync(id);
            return this.RedirectToAction(nameof(Index));
        }

        [HttpGet]
        public async Task<IActionResult> Cart()
        {
            var models = await this.productService.GetCartAsync(this.User.GetId()!);
            return this.View(models);
        }

        [HttpPost]
        public async Task<IActionResult> AddToCart(int id)
        {
            var userId = this.User.GetId();
            await this.productService.AddToCartAsync(userId!, id);

            return this.RedirectToAction(nameof(Index));
        }

        [HttpPost]
        public async Task<IActionResult> RemoveFromCart(int id)
        {
            var userId = this.User.GetId();
            await this.productService.RemoveFromCartAsync(userId!, id);

            return this.RedirectToAction(nameof(Cart));
        }

        private async Task LoadCategoriesAsync(ProductFormModel viewModel)
        {
            var categories = await this.categoryService.GetAllAsync();

            var categorySelectList = categories
               .Select(c => new SelectListItem()
               {
                   Value = c.Id.ToString(),
                   Text = c.Name
               });

            viewModel.Categories = categorySelectList;
        }
    }
}
