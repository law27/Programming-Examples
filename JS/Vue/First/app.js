
Vue.config.devtools = true;

const searchOption = new Vue({
    el: "#search-section",
    data: {
        searchValue: '',
        items: []
    },
    methods: {
        searchRepos: function () {
            const url = `https://api.github.com/search/repositories?q=${this.searchValue}&sort=stars&per_page=10&page=1`
            fetch(url)
                .then( (res) => res.json())
                .then(data => this.items = data.items);
        }
    }
})

/*
Vue.component("repo", {
    props: ["index", "repo", "repoLink", "stars", "forks"],
    template: `<tr>
        <td>{{ index }}</td>
        <td>{{ repo }}</td>
        <td>{{ repoLink }}</td>
        <td>{{ stars }}</td>
        <td>{{ forks }}</td>
      </tr>`
})*/
