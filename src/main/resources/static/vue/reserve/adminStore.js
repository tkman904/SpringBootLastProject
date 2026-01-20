const { defineStore } = Pinia

const useAdminStore = defineStore('admin', {
	state: ()=> ({
		reserve_list: []
	}),
	actions: {
		async dataRecv() {
			const res = await api.get('/admin/reserve_list_vue/')
			console.log(res.data)
			this.reserve_list = res.data
		}
	}
})