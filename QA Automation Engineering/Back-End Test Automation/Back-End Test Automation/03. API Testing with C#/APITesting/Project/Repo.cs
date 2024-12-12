using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoAPITesting
{
    public class Repo
    {
        public int Id { get; set; }

        [JsonProperty("title")]
        public string Title { get; set; }

        public string html_url { get; set; }

        public string full_name { get; set; }
    }
}
