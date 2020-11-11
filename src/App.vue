<template>
  <input v-model="words" placeholder="Input words">
  <button v-on:click="getEntry">Search</button>
  <ul v-if="entries && entries.length">

    <li v-for="entry in entries" :key="entry.word">
      <p><strong>{{entry.word}}</strong></p>
      <p>Phonetic: {{entry.phonetics.text}}</p>
      <button v-on:click="downloadMp3(entry.phonetics.audio)">DownLoad</button>
      <p>Part of Speech: {{entry.meanings.partOfSpeech}}</p>
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
    },
    onClick(event) {
              axios({
                    url: event.target.value,
                    method: 'GET',
                    responseType: 'blob',
                }).then((response) => {
                     var fileURL = window.URL.createObjectURL(new Blob([response.data]));
                     var fileLink = document.createElement('a');

                     fileLink.href = fileURL;
                     fileLink.setAttribute('download', 'file.mp3');
                     document.body.appendChild(fileLink);

                     fileLink.click();
                });
          }

  }
}
</script>