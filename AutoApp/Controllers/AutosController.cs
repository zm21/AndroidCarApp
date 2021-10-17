using AutoApp.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AutoApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AutosController : ControllerBase
    {
        [HttpGet]
        [Route("list")]
        public async Task<IActionResult> ListAuto()
        {
            List<AutoItemViewModel> list = new List<AutoItemViewModel>();
            list.Add(new AutoItemViewModel
            {
                Name="Audi 300",
                Price=203922,
                Image="images/audi.jpg",
                Description= "Для таксі"
            });
            list.Add(new AutoItemViewModel
            {
                Name = "Жигулі 2101",
                Price = 25345,
                Image = "images/zuguli.jpg",
                Description = "Для реальних пацанів"
            });
            return Ok(list);
        }
    }
}
