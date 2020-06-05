<template>
    <div id="tableDiv" >
        <table class="table">
            <thead>
            <th v-for="header in tableHeader">{{header}}</th>
            </thead>
            <tbody>
            <tr v-for="late in statList">
                <td>{{ late.name }}</td>
                <td>{{ late.minutes }}</td>
                <td>{{ late.date }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Stats",
        data () {
            return {
                late: {
                    name: '',
                    minutes: null,
                    date: null,
                },
                tableHeader:['Name', 'Minutes', 'Date'],
            }
        },
        computed: {
            statList () {
                return this.$store.getters.statList
            }
        },
        created() {
            this.$store.dispatch("getStatList")
        }

    }
</script>

<style scoped>
    #tableDiv {
        margin-top:  20px;
        margin-left: 20%;
        margin-right: 20%;
    }
</style>