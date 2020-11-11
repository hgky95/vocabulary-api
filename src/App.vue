<template>
  <input v-model="words" placeholder="Input words">
  <button v-on:click="getEntry">Search</button>
  <ul v-if="entries && entries.length">

    <li v-for="entry in entries" :key="entry.word">
      <p><strong>{{entry.word}}</strong></p>
      <p>{{entry.phonetics}}</p>
      <p>{{entry.meanings}}</p>
    </li>
  </ul>

  
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      entries: [],
      words: []
    }
  },

  methods: {
    getEntry : function () {
      console.log(this.words);
      let url = `https://api.dictionaryapi.dev/api/v2/entries/en/` + this.words;
    axios.get(url)
    .then(response => {
      // JSON responses are automatically parsed.
      this.entries = response.data
    })
    .catch(e => {
      this.errors.push(e)
    })
  }

  // Fetches posts when the component is created.
  

    // async / await version (created() becomes async created())
    //
    // try {
    //   const response = await axios.get(`http://jsonplaceholder.typicode.com/posts`)
    //   this.posts = response.data
    // } catch (e) {
    //   this.errors.push(e)
    // }
  }
}
</script>